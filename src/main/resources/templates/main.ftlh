<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>Email: ${email!}</div>
    <div><@l.logout "/auth/logout"/></div>

    <span><a href="/users"> UserPage</a></span> <br> <br>
    <a href="/persons">Persons page</a> <br>
    <a href="/diagnoses">Diagnoses page</a> <br>
    <a href="/ward">Wards page</a> <br>
</@c.page>
