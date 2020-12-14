package com.cg.addressbook.demo.Repository;

import com.cg.addressbook.demo.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<Contact,Long> {
}
