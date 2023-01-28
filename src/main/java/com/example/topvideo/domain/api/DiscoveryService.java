package com.example.topvideo.domain.api;

import com.example.topvideo.domain.discovery.Discovery;
import com.example.topvideo.domain.discovery.DiscoveryDao;
import com.example.topvideo.domain.user.UserDao;

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

    private static class DiscoveryMapper{
        private final UserDao userDao = new UserDao();
         DiscoveryBasicInfo map(Discovery discovery){
            return new DiscoveryBasicInfo(
                    discovery.getTitle(),
                    discovery.getUrl(),
                    discovery.getDescription(),
                    discovery.getDateAdded()
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