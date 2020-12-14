package com.cg.addressbook.demo.Services;

import com.cg.addressbook.demo.DTO.ContactDTO;
import com.cg.addressbook.demo.Model.Contact;
import com.cg.addressbook.demo.Exceptions.ContactNotFoundException;
import com.cg.addressbook.demo.Exceptions.DetailsNotProvidedException;
import com.cg.addressbook.demo.Repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public ContactDTO CreateContact(ContactDTO contactDTO){
        if(Objects.nonNull(contactDTO.getName()) && Objects.nonNull(contactDTO.getCity()) &&
                Objects.nonNull(contactDTO.getState()) && Objects.nonNull(contactDTO.getPhone()) &&
                Objects.nonNull(contactDTO.getEmail())) {
            Contact contact = new Contact(contactDTO.getName(),contactDTO.getCity(),
                                            contactDTO.getState(),contactDTO.getPhone(),
                                            contactDTO.getEmail());
            return new ContactDTO(addressBookRepository.save(contact));
        }

        throw new DetailsNotProvidedException("Invalid Data");
    }

    public ContactDTO Updatecontact(ContactDTO contactDTO){

        return addressBookRepository.findById(contactDTO.getId()).map(contact -> {
            if(Objects.nonNull(contactDTO.getName())){
                contact.setName(contactDTO.getName());
            }
            if(Objects.nonNull(contactDTO.getCity())){
                contact.setCity(contactDTO.getCity());
            }
            if(Objects.nonNull(contactDTO.getState())){
                contact.setState(contactDTO.getState());
            }
            if(Objects.nonNull(contactDTO.getPhone())){
                contact.setPhone(contactDTO.getPhone());
            }
            if(Objects.nonNull(contactDTO.getEmail())){
                contact.setEmail(contactDTO.getEmail());
            }
            return new ContactDTO(addressBookRepository.save(contact));
        }).orElseThrow(()-> new ContactNotFoundException("ContactNotFound"));
    }

    public ContactDTO deleteContact(Long id){
        return addressBookRepository.findById(id).map(contact -> {
            addressBookRepository.deleteById(contact.getId());
            return new ContactDTO(contact);
        }).orElseThrow(()-> new ContactNotFoundException("ContactNotFound"));
    }


    public List<ContactDTO> getAllContacts(){
        return addressBookRepository.findAll()
                .stream()
                .map(contact -> new ContactDTO(contact))
                .collect(Collectors.toList());
    }
}
