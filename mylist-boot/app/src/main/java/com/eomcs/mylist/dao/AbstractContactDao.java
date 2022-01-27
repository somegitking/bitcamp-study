package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;

public abstract class AbstractContactDao implements ContactDao {


  protected ArrayList contactList = new ArrayList(); 

  protected abstract void save() throws Exception;

  @Override
  public int countAll() {
    return contactList.size();
  }

  @Override
  public Object[] findAll() {
    return contactList.toArray();
  }

  @Override
  public void insert(Contact contact) throws Exception {
    contactList.add(contact);
    save();
  }

  @Override
  public Contact findByNo(int no) {
    if (no < 0 || no >= contactList.size()) {
      return null;
    }
    return (Contact) contactList.get(no);
  }

  @Override
  public int update(int no, Contact contact) throws Exception {
    System.out.println("update");
    if (no < 0 || no >= contactList.size()) {
      return 0;
    }
    contactList.set(no, contact);
    save();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    System.out.println("delete");
    if (no < 0 || no >= contactList.size()) {
      return 0;
    }
    contactList.remove(no);
    save();
    return 1;
  }


}











