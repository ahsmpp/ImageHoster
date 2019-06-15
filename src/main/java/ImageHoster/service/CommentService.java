package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //Call the addComment() method in the CommentRepository class to persist the comment record in the database
    public Comment addComment(Comment comment) {
        return commentRepository.addComment(comment);
    }

    //The method calls the findComments() method in the CommentRepository and passes the imageId of the comments to be fetched
    public List<Comment> findComments(Integer imageId) {
        return  commentRepository.findComments(imageId);
    }
}
