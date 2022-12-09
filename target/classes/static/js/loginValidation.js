"use strict";

function loginItensValidation(form){

    let loginDefault = "teste@email.com"
    let passwDefault = "123123123"
    
    document.getElementById('message').style.display = ''
    
    let message = document.getElementById('message');
    let msg = ""
   
    if (login.value === loginDefault && passwd.value === passwDefault){
        document.getElementById('message').style.display = 'none'
        form.action = "index.html";
    }else{
        switch(login){
            case loginDefault:
                msg = 'SENHA incorreta!'
                break;
            default:
                msg = 'Dados de LOGIN não cadastrado ou inválidos!'
                break;
        }
        message.innerHTML = msg;
        message.className = 'message';
        passwd.value = ""
        event.preventDefault();
    };
};

function clearMsg(){
    document.getElementById('message').style.display = 'none';
};