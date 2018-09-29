package com.clj.journalism.mapper;

import com.clj.journalism.bean.UserBook;
import com.clj.journalism.bean.UserBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBookMapper {
    Integer saveShelf(UserBook userBook);

    Integer update(UserBook userBook);

    Integer getShelf(UserBook userBook);

    Integer deleteShelt(Integer userId);
}