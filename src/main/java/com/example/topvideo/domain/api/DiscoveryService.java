package com.example.topvideo.domain.api;

import com.example.topvideo.domain.discovery.Discovery;
import com.example.topvideo.domain.discovery.DiscoveryDao;
import com.example.topvideo.domain.user.UserDao;
import com.example.topvideo.domain.vote.VoteDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DiscoveryService {
    private final DiscoveryDao discoveryDao = new DiscoveryDao();
    private final DiscoveryMapper discoveryMapper = new DiscoveryMapper();

    public void add(DiscoverySaveRequest saveRequest){
        Discovery discoveryToSave = discoveryMapper.map(saveRequest);
        discoveryDao.save(discoveryToSave);
    }
    public List<DiscoveryBasicInfo> findAll(){
        return discoveryDao.findAll()
                .stream().map(discoveryMapper::map)
                .collect(Collectors.toList());
    }

    public List<DiscoveryBasicInfo> findByCategory(int categoryId){
        return discoveryDao.findByCategory(categoryId)
                .stream().map(discoveryMapper::map)
                .collect(Collectors.toList());
    }

    public List<DiscoveryBasicInfo> findByUserId(int userId){
        return discoveryDao.findByUserId(userId)
                .stream().map(discoveryMapper::map)
                .collect(Collectors.toList());
    }

    private static class DiscoveryMapper{
        private final UserDao userDao = new UserDao();
        private final VoteDao voteDao = new VoteDao();
         DiscoveryBasicInfo map(Discovery discovery){
            return new DiscoveryBasicInfo(
                    discovery.getId(),
                    discovery.getTitle(),
                    discovery.getUrl(),
                    discovery.getDescription(),
                    discovery.getDateAdded(),
                    voteDao.countByDiscoveryId(discovery.getId()),
                    userDao.findById(discovery.getUserId()).orElseThrow().getUsername()
            );
        }

        Discovery map(DiscoverySaveRequest ds){
             return new Discovery(
                     ds.getTitle(),
                     ds.getUrl(),
                     ds.getDescription(),
                     LocalDateTime.now(),
                     ds.getCategoryId(),
                     userDao.findByUsername(ds.getAuthor())
                             .orElseThrow()
                             .getId()
             );
        }
    }
}
