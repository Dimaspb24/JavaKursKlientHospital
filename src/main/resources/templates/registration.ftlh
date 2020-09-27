<#import "parts/common.ftlh" as c>
<#import "parts/registration.ftlh" as r>

<@c.page>
    <h1>Registration</h1><br>
    <h5>${message!}</h5> <br>
    <@r.registration "/auth/registration" />
</@c.page>