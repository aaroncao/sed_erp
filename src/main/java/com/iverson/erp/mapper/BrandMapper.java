package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Brand;
import com.iverson.erp.provider.BrandSqlProvider;
import com.iverson.erp.vo.BrandVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BrandMapper {

    @Insert("insert into sed_market_brand(brand_no,name,status) values(#{brandNo},#{name},#{status})")
    int addOne(Brand brand);

    @SelectProvider(type = BrandSqlProvider.class, method = "getListSql")
    List<Brand> getList(@Param("brandNo") String brandNo,
                        @Param("name") String name,
                        @Param("status") Integer status);

    @UpdateProvider(type = BrandSqlProvider.class, method = "getUpdateSql")
    int update(Brand brand);

    @Select("select brand_no, name from sed_market_brand where status=#{status}")
    List<BrandVO> getAll(Integer status);
}