package cn.leopisces.springboot.dao;

import java.io.Serializable;

import cn.leopisces.springboot.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: cn.leopisces.springboot.dao
 * @Author: leopisces
 * @CreateTime: 2022-12-29  22:38
 * @Description: IBaseDao
 * @Version: 1.0
 */
@NoRepositoryBean
public interface IBaseDao<T extends BaseEntity, I extends Serializable>
        extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
}
