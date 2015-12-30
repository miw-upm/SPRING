package spring.persistence.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.BidirectionalManyToManyDao;
import spring.persistence.entities.BidirectionalManyToManyEntity;
import spring.persistence.entities.ManyToManyMappedByEntity;

@Controller
public class BidirectionalManyToManyController {

    @Autowired
    private BidirectionalManyToManyDao bidirectionalManyToManyDao;

    public void process() {
        ManyToManyMappedByEntity[] array = {new ManyToManyMappedByEntity("uno"), new ManyToManyMappedByEntity("dos"),
                new ManyToManyMappedByEntity("tres")};
        BidirectionalManyToManyEntity entity = new BidirectionalManyToManyEntity("Mi Nick", Arrays.asList(array));
        BidirectionalManyToManyEntity[] entityArray = {entity};
        for (ManyToManyMappedByEntity manyToManyMappedByEntity : array) {
            manyToManyMappedByEntity.setBidirectionalManyToManyEntityList(Arrays.asList(entityArray));
        }
        bidirectionalManyToManyDao.save(entity);

        System.out.println(">>>> BidirectionalManyToManyEntity:  " + bidirectionalManyToManyDao.findOne(entity.getId()));
    }
}