<!DOCTYPE html>
<html>
<body>
<h1>Wpisz dane kredytu.</h1>
<h2>Uwaga: program zakłada, że raty są równe a oprocentowanie nie zmienia się w czasie.</h2>
</br>
<form method="POST" action="/loanSimulator">
    Kwota kredytu: <input type="text" name="loan" required/><br/><br/>
    Okres kredytowania (w miesiącach): <input type="text" name="months" required/><br/><br/>
    Marża banku (w procentach): <input type="text" name="profit" required/><br/><br/>
    Prowizja banku (w procentach): <input type="text" name="markup" required/><br/><br/>
    <input type="submit" name="save" value="save"/><br/>
    <input type="reset" name="reset" value="clear"/>
</form>
</br>

<#if loanParams??>
    RRSO: ${APR} %
    </br>
    Całkowity koszt kredytu (kapitał + odsetki): ${totalCostOfCredit}
<#else>
    RRSO: brak danych
    </br>
    Całkowity koszt kredytu (kapitał + odsetki): brak danych
</#if>
</br></br>

<#if loanParams??>
<table id="loan" class="loan" style="width:50%" border="1">
    <tr>
        <th>Numer miesiąca</th>
        <th>Kwota raty</th>
        <th>Kwota pozostała do spłaty</th>
    </tr>
    <#list loanParams as param>
        <tr>
            <td>${param.month}</td>
            <td>${param.rate}</td>
            <td>${param.loanLeft}</td>
        </tr>
    </#list>
</#if>
</table>

</body>
</html>