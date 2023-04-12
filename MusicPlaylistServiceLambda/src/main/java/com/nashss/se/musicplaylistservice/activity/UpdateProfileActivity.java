package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateProfileRequest;
import com.nashss.se.musicplaylistservice.activity.results.UpdateProfileResult;
import com.nashss.se.musicplaylistservice.converters.ModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.ProfileDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Profile;
import com.nashss.se.musicplaylistservice.metrics.MetricsConstants;
import com.nashss.se.musicplaylistservice.metrics.MetricsPublisher;
import com.nashss.se.projectresources.music.playlist.servic.util.MusicPlaylistServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;
import java.time.ZonedDateTime;

public class UpdateProfileActivity {
    private final Logger log = LogManager.getLogger();
    private final ProfileDao profileDao;
    private final MetricsPublisher metricsPublisher;

    @Inject
    public UpdateProfileActivity(ProfileDao profileDao, MetricsPublisher metricsPublisher){
        this.profileDao = profileDao;
        this.metricsPublisher = metricsPublisher;
    }

    public UpdateProfileResult handleRequest(final UpdateProfileRequest updateProfileRequest)  {
        log.info("Received UpdateProfileRequest{}", updateProfileRequest);


        Profile profile = profileDao.saveProfile(false, updateProfileRequest.getProfileId(),
               updateProfileRequest.getFirstName(), updateProfileRequest.getLastName(), updateProfileRequest.getLocation(),
               updateProfileRequest.getGender(), ZonedDateTime.parse(updateProfileRequest.getDateOfBirth()));

        publishExceptionMetrics(false,false);
        return UpdateProfileResult.builder()
                .withProfile(new ModelConverter().toProfileModel(profile))
                .build();
    }
    private void publishExceptionMetrics(final boolean isInvalidAttributeValue,
                                         final boolean isInvalidAttributeChange) {
        metricsPublisher.addCount(MetricsConstants.UPDATEPROFILE_INVALIDATTRIBUTECHANGE_COUNT,
                isInvalidAttributeValue ? 1 : 0);
        metricsPublisher.addCount(MetricsConstants.UPDATEPROFILE_INVALIDATTRIBUTECHANGE_COUNT,
                isInvalidAttributeChange ? 1 : 0);
    }
}