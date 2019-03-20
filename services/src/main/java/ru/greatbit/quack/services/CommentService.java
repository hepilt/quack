package ru.greatbit.quack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.greatbit.quack.beans.Comment;
import ru.greatbit.quack.dal.CommentRepository;
import ru.greatbit.quack.dal.CommonRepository;
import ru.greatbit.whoru.auth.Session;

@Service
public class CommentService extends BaseService<Comment> {

    @Autowired
    private CommentRepository repository;

    @Override
    protected CommonRepository<Comment> getRepository() {
        return repository;
    }

    @Override
    protected void beforeSave(Session session, Comment entity) {
        super.beforeSave(session, entity);
        entity.setTextFormatted(entity.getText());
    }

    @Override
    protected boolean userCanDelete(Session session, String projectId, String id) {
        Comment comment = findOne(session, projectId, id);
        return super.userCanDelete(session, projectId, id) || userIsTheOwner(session, comment);
    }

    @Override
    protected boolean userCanUpdate(Session session, String projectId, Comment entity) {
        return super.userCanUpdate(session, projectId, entity) || userIsTheOwner(session, entity);
    }

    private boolean userIsTheOwner(Session session, Comment comment) {
        return session.getPerson().getId().equals(comment.getCreatedBy());
    }

}