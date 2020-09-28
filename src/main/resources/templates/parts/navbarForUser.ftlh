<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/auth/main">Hospital</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
<#--            <li class="nav-item">-->
<#--                <a class="nav-link" href="/auth/main">Home</a>-->
<#--            </li>-->
            <li class="nav-item">
                <a class="nav-link" href="/persons">Persons</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/diagnoses">Diagnoses</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/wards">Wards</a>
            </li>
        </ul>

        <#--        Сюда нужно добавить емаил текущего юзера - желательно как постояную переменую-->
        <#--        <div class="navbar-text mr-3">${currentEmail}</div>-->
        <div><@l.logout "/auth/logout"/></div>
    </div>
</nav>