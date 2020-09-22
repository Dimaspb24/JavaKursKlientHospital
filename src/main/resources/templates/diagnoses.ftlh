<#import "parts/common.ftlh" as c >
<#import "parts/login.ftlh" as l>

<@c.page>
    Start diagnoses
    <div>
<#--        Пользователь: ${user}-->
        <div>
            <@l.logout "/auth/logout"/>
        </div>

        <form method="post" accept-charset="UTF-8" action="/diagnoses/save">
            <input type="text" name="name" placeholder="Введите новое имя"/>
            <button type="submit">Добавить</button>
        </form>

        <form method="get" action="/diagnoses">
<#--            value="${filter}"-->
            <input type="text" name="filter" placeholder="Введите имя диагноза" >
            <button type="submit">Найти</button>
        </form>
    </div>

    <div>Список диагнозов</div>
    <#list diagnosesList as diagnosis>
        <div>
            <p>${diagnosis.id}
                <span>${diagnosis.name}
        </div>
<#--    <#else>-->
<#--        No diagnosis-->
    </#list>

</@c.page>