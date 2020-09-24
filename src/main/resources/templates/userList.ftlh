<#import "parts/common.ftlh" as c >

<@c.page>
    <h2> List of users </h2>

    <table>
        <thead>
        <tr>
            <th>Email</th>
<#--            <th>Password</th>-->
            <th>First Name</th>
            <th>Last Name</th>
            <th>Role</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.email}
<#--                <td>${user.password}-->
                <td>${user.firstName}
                <td>${user.lastName}
                <td>${user.role}
                <td>${user.status}
                <td><a href="/users/${user.email}"> Edit </a>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>