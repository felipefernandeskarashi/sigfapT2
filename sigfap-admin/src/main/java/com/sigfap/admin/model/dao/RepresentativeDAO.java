package com.sigfap.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;

import com.sigfap.admin.model.entity.Representative;

public class RepresentativeDAO extends HibernateDAO<Representative, Integer> {

}
