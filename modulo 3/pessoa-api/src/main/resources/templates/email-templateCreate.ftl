<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Java Mail</title>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td align="center" valign="top" bgcolor="#8C90E7"
            style="background-color: #838383;"><br> <br>
            <table width="600" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="center" valign="top" bgcolor="#8C90E7"
                        style="background-color: #d3be6c; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #000000; padding: 0px 15px 10px 15px;">

                        <div style="font-size: 20px; color:blue;">
                            <b>Endereco criado</b>
                        </div>

                        <div style="font-size: 24px; color: #555100;">
                            <br>Olá<b>${nome},</b>  <br>Um endereço foi criado em seu nome. o identificador é <b>idEndereco:${idEndereco}</b>
                            <br>Qualquer duvida é so contatar o suporte pelo email " ${from} <br>
                            Att, <br>
                            Sistema.
                        </div>
                        <div>
                            <br><br> <br>
                            <br> <br> <b>${nome} - ${email}</b>
                            <br>
                        </div>
                    </td>
                </tr>
            </table> <br> <br></td>
    </tr>
</table>
</body>
</html>