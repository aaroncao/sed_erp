package com.iverson.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iverson.erp.form.ValueCardForm;
import com.iverson.erp.mapper.ValueCardMapper;
import com.iverson.erp.pojo.ValueCard;
import com.iverson.erp.service.ValueCardService;
import com.iverson.erp.util.NoGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ValueCardServiceImpl implements ValueCardService {

    @Autowired
    private ValueCardMapper valueCardMapper;

    @Override
    @Transactional
    public int addOne(ValueCardForm valueCardForm) {
        ValueCard valueCard = new ValueCard();
        valueCard.setCardNo(NoGenerateUtil.getValueCardNo());
        valueCard.setHolder(valueCardForm.getHolder());
        valueCard.setBalance(valueCardForm.getBalance());
        valueCard.setPhoneNumber(valueCardForm.getPhoneNumber());
        return valueCardMapper.addOne(valueCard);
    }

    @Override
    public PageInfo<ValueCard> getCards(String cardNo, String holder, String phoneNumber, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ValueCard> valueCards = valueCardMapper.getList(cardNo, holder, phoneNumber);
        PageInfo<ValueCard> valueCardPageInfo = new PageInfo<>(valueCards);
        return valueCardPageInfo;
    }

    @Override
    @Transactional
    public int updateValueCardByCardNo(ValueCardForm valueCardForm) {
        ValueCard valueCard = new ValueCard();
        if(valueCardForm.getCardNo() == null){
            return 0;//错误
        }
        valueCard.setCardNo(valueCardForm.getCardNo());
        valueCard.setHolder(valueCardForm.getHolder());
        valueCard.setPhoneNumber(valueCardForm.getPhoneNumber());
        valueCard.setBalance(valueCardForm.getBalance());
        return valueCardMapper.update(valueCard);
    }
}
