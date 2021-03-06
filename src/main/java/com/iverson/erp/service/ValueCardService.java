package com.iverson.erp.service;

import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.ValueCardForm;
import com.iverson.erp.pojo.ValueCard;

public interface ValueCardService {

    int addOne(ValueCardForm valueCardForm);

    PageInfo<ValueCard> getCards(String cardNo, String holder, String phoneNumber, int pageNum, int pageSize);

    int updateValueCardByCardNo(ValueCardForm valueCardForm);
}
