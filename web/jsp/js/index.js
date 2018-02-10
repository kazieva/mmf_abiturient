function validateRegistrationForm(){
    var flag = true;
    var exception_style = "2px groove #bf173b";
    var email_pattern=/[0-9a-z_]+@[0-9a-z_]+\.[a-z]{2,5}/i;

    // проверка email
    var email = document.getElementById('user_login');
    email.style.border="";
    if(email.value.trim()==""){
        email.style.border=exception_style;
        flag = false;
    }
    else{
        if(email_pattern.test(email.value)==false){
            email.style.border=exception_style;
            flag =false;
        }
        else;
    }
    //pass
    var pass = document.getElementById('user_pass');
    pass.style.border="";
    if(pass.value.trim()==""){
        pass.style.border=exception_style;
        flag = false;
    }
    //key
    var key = document.getElementById('user_key');
    key.style.border="";
    if(key.value.trim()==""){
        key.style.border=exception_style;
        flag = false;
    }
    var name_pattern=/([a-zA-Z]+|[а-яА-я]+)/i;

    // name
    var fname = document.getElementById('user_fname');
    fname.style.border="";
    if(fname.value.trim()==""){
        fname.style.border=exception_style;
        flag = false;
    }
    else{
        if(name_pattern.test(fname.value)==false){
            fname.style.border=exception_style;
            flag =false;
        }
        else;
    }
    // sname
    var sname = document.getElementById('user_sname');
    sname.style.border="";
    if(sname.value.trim()==""){
        sname.style.border=exception_style;
        flag = false;
    }
    else{
        if(name_pattern.test(sname.value)==false){
            sname.style.border=exception_style;
            flag =false;
        }
        else;
    }
    return flag;
}
function validateLoginForm(){
    var flag = true;
    var exception_style = "2px groove #bf173b";
    var email_pattern=/[0-9a-z_]+@[0-9a-z_]+\.[a-z]{2,5}/i;

    // проверка email
    var email = document.getElementById('user_login');
    email.style.border="";
    if(email.value.trim()==""){
        email.style.border=exception_style;
        flag = false;
    }
    else{
        if(email_pattern.test(email.value)==false){
            email.style.border=exception_style;
            flag =false;
        }
        else;
    }
    //pass
    var pass = document.getElementById('user_pass');
    pass.style.border="";
    if(pass.value.trim()==""){
        pass.style.border=exception_style;
        flag = false;
    }
    //key
    var key = document.getElementById('user_key');
    key.style.border="";
    if(key.value.trim()==""){
        key.style.border=exception_style;
        flag = false;
    }
    return flag;
}
function validateNewSpecialityForm(){
    var flag = true;
    var exception_style = "2px groove #bf173b";

    var id = document.getElementById('id');
    id.style.border="";
    if(id.value.trim()==""){
        id.style.border=exception_style;
        flag = false;
    }
    else{
        if(id.value<1){
            id.style.border=exception_style;
            flag =false;
        }
        else;
    }
    var en_name = document.getElementById('en_speciality_name');
    en_name.style.border="";
    if(en_name.value.trim()==""){
        en_name.style.border=exception_style;
        flag = false;
    }
    var ru_name = document.getElementById('ru_speciality_name');
    ru_name.style.border="";
    if(ru_name.value.trim()==""){
        ru_name.style.border=exception_style;
        flag = false;
    }
    var recruitment_plan = document.getElementById('recruitment_plan');
    recruitment_plan.style.border="";
    if(recruitment_plan.value.trim()==""){
        recruitment_plan.style.border=exception_style;
        flag = false;
    }
    else{
        if(irecruitment_pland.value<1){
            recruitment_plan.style.border=exception_style;
            flag =false;
        }
        else;
    }
    return flag;
}