
function validateRegistrationForm(){
    var flag = true;
    var exception_style = "2px groove #bf173b";
    var email_pattern=/[0-9a-z_]+@[0-9a-z_]+\.[a-z]{2,5}/i;

    // email
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
    var name_pattern=/^[A-ZА-Я][a-zа-я]*[a-zа-я]+$/g;

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
    }/*
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
    }*/
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
        if(recruitment_plan.value<1){
            recruitment_plan.style.border=exception_style;
            flag =false;
        }
        else;
    }
    return flag;
}
function validateAbiturient() {
    var flag = true;
    var exception_style = "2px groove #bf173b";
    var passport_series = document.getElementById('passport_series');
    var passport_id = document.getElementById('passport_id');
    var sname = document.getElementById('sname');
    var fname = document.getElementById('fname');
    var patronymic = document.getElementById('patronymic');
    var phone = document.getElementById('phone');
    var math = document.getElementById('math_certificate');
    var physics = document.getElementById('physics_certificate');
    var language = document.getElementById('language_certificate');
    var school = document.getElementById('school_certificate');


//    var name_pattern=/([a-zA-Z]{1,20}|[а-яА-я]{1,20})/g;
    var name_pattern= /^[a-zA-Zа-яА-Я][a-zA-Zа-яА-Я\-]+[a-zA-Zа-яА-Я]?$/u;
    var series_pattern=/^[A-Z]{2}$/g;
    var phone_pattern=/^((8|\+37)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{9,13}$/i;

    passport_series.style.border="";
    if(passport_series.value.trim()==""){
        passport_series.style.border=exception_style;
        flag = false;
    }
    else{
        if(series_pattern.test(passport_series.value)==false){
            passport_series.style.border=exception_style;
            flag =false;
        }
        else;
    }

    passport_id.style.border="";
    if(passport_id.value.trim()==""){
        passport_id.style.border=exception_style;
        flag = false;
    }else{
        if(passport_id.value<1000000){
            passport_id.style.border=exception_style;
            flag =false;
        }
        else;
    }
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
    patronymic.style.border="";
    if(patronymic.value.trim()!=""){
        if(name_pattern.test(patronymic.value)==false){
            patronymic.style.border=exception_style;
            flag =false;
        }
        else;
    }
    phone.style.border="";
    if(phone.value.trim()!=""){
        if(phone_pattern.test(phone.value)==false){
            phone.style.border=exception_style;
            flag =false;
        }
        else;
    }

    math.style.border="";
    if(math.value.trim()==""){
        math.style.border=exception_style;
        flag = false;
    }
    else{
        if(math.value<15||math.value>100){
            math.style.border=exception_style;
            flag =false;
        }
        else;
    }
    physics.style.border="";
    if(physics.value.trim()==""){
        physics.style.border=exception_style;
        flag = false;
    }
    else{
        if(physics.value<15||physics.value>100){
            physics.style.border=exception_style;
            flag =false;
        }
        else;
    }
    language.style.border="";
    if(language.value.trim()==""){
        language.style.border=exception_style;
        flag = false;
    }
    else{
        if(language.value<20||language.value>100){
            language.style.border=exception_style;
            flag =false;
        }
        else;
    }
    school.style.border="";
    if(school.value.trim()==""){
        school.style.border=exception_style;
        flag = false;
    }
    else{
        if(school.value<0||school.value>100){
            school.style.border=exception_style;
            flag =false;
        }
        else;
    }
    return flag;
}