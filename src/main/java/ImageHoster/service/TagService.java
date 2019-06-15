package ImageHoster.service;

import ImageHoster.model.Tag;
import ImageHoster.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    //The method calls the findTag() method in the TagRepository and passes the title of the tag to be fetched
    public Tag getTagByName(String title) {
        return tagRepository.findTag(title);
    }

    //Call the createTag() method in the TagRepository class to persist the tag record in the database
    public Tag createTag(Tag tag) {
        return tagRepository.createTag(tag);
    }
}
