package com.sigfap.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;

import com.sigfap.admin.model.entity.Address;

public class AddressDAO extends HibernateDAO<Address, Integer>{

}
