<#import "parts/common.ftlh" as c>
<#import "parts/registration.ftlh" as r>

<@c.page>
    Add new user
    <h1>Registration ${message!}</h1>
    <@r.registration "/auth/registration" />
</@c.page>