package com.lzx.sys.base.dao;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> extends JpaRepository<T,ID> {
	Optional<T> findById(ID id);
}
