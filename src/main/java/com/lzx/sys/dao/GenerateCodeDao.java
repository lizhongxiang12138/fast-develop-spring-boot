package com.lzx.sys.dao;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lzx.sys.base.dao.BaseDao;
import com.lzx.sys.entity.GenerateCode;

@RepositoryRestResource(collectionResourceRel="generateCode",path="generateCode")
public interface GenerateCodeDao extends BaseDao<GenerateCode, String> {
	
	Optional<GenerateCode> findById(@Param("id") String id);
	
}
