package com.example.topvideo.domain.discovery;

import com.example.topvideo.domain.api.DiscoveryBasicInfo;

import java.util.Comparator;

public class DiscoveryVoteComparator implements Comparator<DiscoveryBasicInfo> {

    @Override
    public int compare(DiscoveryBasicInfo o1, DiscoveryBasicInfo o2) {
        return -Integer.compare(o1.getVoteCount(), o2.getVoteCount());
    }
}
