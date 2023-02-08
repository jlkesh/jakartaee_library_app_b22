package dev.jlkesh.library.library.dao;

import dev.jlkesh.library.library.domains.Document;

public class DocumentDAO extends DAO<Document, Integer> {
    @Override
    protected void save(Document document) {

    }

    @Override
    protected boolean get(Integer integer) {
        return false;
    }

    @Override
    protected boolean update(Document document) {
        return false;
    }

    @Override
    protected boolean delete(Integer integer) {
        return false;
    }
}
