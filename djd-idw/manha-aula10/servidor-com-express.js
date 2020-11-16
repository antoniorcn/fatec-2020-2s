const express = require('express');
const app = express();
app.use(express.static('./public'));
app.set('view engine', 'hbs');
const teste = (request, response) => {
    console.log("Função anonima");
    response.send("<h1>Teste de página com função anônima</h1>")
}
app.get("/teste", teste);
app.get("/bomdia", (request, response) => { 
    let nomeCompleto = request.query.nomecompleto;
    const agora = Date();
    response.render("teste", {nome: nomeCompleto, horas:agora});
    
})
app.listen(80, () => {
    console.log("Servidor iniciado");
});