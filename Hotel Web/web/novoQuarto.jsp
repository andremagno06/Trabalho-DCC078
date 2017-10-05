<%-- 
    Document   : Formulário de quartos
    Created on : 04/10/2017, 15:17:24
    Author     : Ana Carolina Fidelis Gonçalves
                 André Magno
                 Davi de Almeida
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>QUARTOS >> NOVO</h2>   
            </div>
        </div>            
        <hr/>

        <h1>Cadastro de Quarto</h1>
        <form action="FrontController?action=InserirQuarto" method="post">
            Entre com seu nome
            <input type="text" name="textDescricao"/><br/>

            Entre com o tipo de quarto
            <input type="text" name="textTipo"/><br/>
            <input type="submit"/>

        </form>
<!--        <h1>Excluir de Quarto</h1>
        <form action="FrontController?action=ApagarQuarto" method="post">
            Entre com seu nome
            <input type="text" name="textNome"/><br/>
            <input type="submit"/>
        </form>-->
    </div>
</div>