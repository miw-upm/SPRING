package spring.persistence.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.persistence.daos.BidirectionalOneToManyMappedByDao;
import spring.persistence.entities.BidirectionalOneToManyMappedByEntity;
import spring.persistence.entities.ManyToOneJoinColumnEntity;

@Controller
public class BidirectionalOneToManyMappedByController {

    @Autowired
    private BidirectionalOneToManyMappedByDao bidirectionalOneToManyMappedByDao;

    public void process() {
        ManyToOneJoinColumnEntity[] array = {new ManyToOneJoinColumnEntity("uno"), new ManyToOneJoinColumnEntity("dos"),
                new ManyToOneJoinColumnEntity("tres")};
        BidirectionalOneToManyMappedByEntity entity = new BidirectionalOneToManyMappedByEntity("Mi Nick", Arrays.asList(array));
        for (ManyToOneJoinColumnEntity manyToOneJoinColumnEntity : array) {
            manyToOneJoinColumnEntity.setBidirectionalOneToManyMappedByEntity(entity);
        }
        bidirectionalOneToManyMappedByDao.save(entity);

        System.out.println(">>>> BidirectionalOneToManyMappedByEntity:  " + bidirectionalOneToManyMappedByDao.findOne(entity.getId()));
    }
}
