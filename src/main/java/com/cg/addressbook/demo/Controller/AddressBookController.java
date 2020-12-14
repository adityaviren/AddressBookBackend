package com.cg.addressbook.demo.Controller;

import com.cg.addressbook.demo.DTO.ContactDTO;
import com.cg.addressbook.demo.Exceptions.ContactNotFoundException;
import com.cg.addressbook.demo.Services.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @PostMapping("/create")
    public ResponseEntity<ContactDTO> createUser(@RequestBody ContactDTO contact){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(addressBookService.CreateContact(contact));
        } catch (ContactNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/update")
    public ResponseEntity<ContactDTO> updateUser(@RequestBody ContactDTO user){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(addressBookService.Updatecontact(user));
        } catch (ContactNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ContactDTO> deleteUser(@PathVariable("id")Long id){
        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addressBookService.deleteContact(id));

        } catch (ContactNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<ContactDTO>> getAllUser(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(addressBookService.getAllContacts());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
