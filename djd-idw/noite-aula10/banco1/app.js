const mysql = require('mysql');

const con = mysql.createConnection(
    {
        host: 'localhost',
        user: 'root',
        password: '123456',
        database: 'filmes'
    }
);

// function erro(e) { 
//     console.log("Erro: ", e);
// }

con.connect((e) => { 
    // console.log(e);
    if (e) throw e;
    console.log("Connected!");
});

// con.query("INSERT INTO filmes (id, titulo, duracao, genero) " + 
// "VALUES (3, 'Harry Potter - Pedra Filosofal', '02:00:00', 'acao')");

const filme = { 
    id: 4,
    titulo: 'Indiana Jones e a última cruzada',
    duracao: '02:00:00',
    genero: 'acao'
};

con.query('INSERT INTO filmes SET ?', filme, (err, res)=>{
    if (err) throw err;
    console.log("Ultimo ID inserido: ", res.insertId);
});
