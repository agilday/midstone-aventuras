package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.AddEventToProfileRequest;
import com.nashss.se.musicplaylistservice.activity.results.AddEventToProfileResult;
import com.nashss.se.musicplaylistservice.dynamodb.EventDao;
import com.nashss.se.musicplaylistservice.dynamodb.ProfileDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/**
 * Implementation of the AddEventToProfileActivity for the AddEventToProfile API.
 *
 * This API allows the user to add an event to their existing event calendar.
 */
public class AddEventToProfileActivity {
    private final Logger log = LogManager.getLogger();
    private final ProfileDao profileDao;
    private final EventDao eventDao;

    /**
     * Instantiates a new AddSongToPlaylistActivity object.
     *
     * @param profileDao ProfileDao to access the profile.
     * @param eventDao eventDao to access the events table.
     */
    @Inject
    public AddEventToProfileActivity(ProfileDao profileDao, EventDao eventDao) {
        this.profileDao = profileDao;
        this.eventDao = eventDao;
    }

    /**
     * This method handles the incoming request by adding an additional event
     * to a profile and persisting the updated profile.
     * <p>
     * It then returns the updated event list of the profile.
     * <p>
     * If the profile does not exist, this should throw a ProfileNotFoundException.
     * <p>
     * If the event does not exist, this should throw an EventNotFoundException.
     *
     * @param addEventToProfileRequest request object containing the profile and eventId
     *                                 to retrieve the event data
     * @return addEventToProfileResult result object containing the profile's updated list of
     *                                 API defined
     */
    public AddEventToProfileResult handleRequest(final AddEventToProfileRequest addEventToProfileRequest) {
        log.info("Received AddEventToProfileRequest {} ", addEventToProfileRequest);

        String eventId = addEventToProfileRequest.getEventId();
        String profileId = addEventToProfileRequest.getProfileId();


        eventDao.getEvent(eventId);

        profileDao.getProfile(addEventToProfileRequest.getProfileId());

        Set<String> updatedSet = profileDao.addEventToFollowing(eventId, profileId);

        List<String> eventModels = new ArrayList<>(updatedSet);
        return AddEventToProfileResult.builder()
                .withEventList(eventModels)
                .build();
    }
}
