package com.nashss.se.musicplaylistservice.metrics;

/**
 * Constant values for use with metrics.
 */
public class MetricsConstants {
    public static final String GETPROFILE_PROFILENOTFOUND_COUNT = "GetProfile.ProfileNotFoundException.Count";
    public static final String GETEVENT_EVENTNOTFOUND_COUNT = "GetEvent.EventNotFoundException.Count";
    public static final String UPDATEEVENT_INVALIDATTRIBUTEVALUE_COUNT =
        "UpdateEvent.InvalidAttributeValueException.Count";
    public static final String SERVICE = "Service";
    public static final String SERVICE_NAME = "MusicPlaylistService";
    public static final String NAMESPACE_NAME = "U3/MusicPlaylistService";
    public static final String UPDATEEVENT_INVALIDATTRIBUTECHANGE_COUNT =
            "UpdateEvent.InvalidAttributeValueException.Count";
    public static final String UPDATEPROFILE_INVALIDATTRIBUTECHANGE_COUNT = "UpdateProfile.InvalidAttributeChangeException.Count";
    public static final String UPDATEPROFILE_INVALIDATTRIBUTEVALUE_COUNT = "UpdateProfile.InvalidAttributeValueException.Count";
}
