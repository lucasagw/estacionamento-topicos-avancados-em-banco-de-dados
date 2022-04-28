Pegar todos os csv's dentro do folder e jogar na pasta temporaria do computador,
depois será necessário abrir o postgres e rodar o seguinte script para cada um dos arquivos:

COPY perfil FROM 'C:/Temp/PERFIL.csv' (format csv, null "NULL", DELIMITER ',', HEADER);


Se atentar a ordem em que as tabelas devem ser populadas e aos erros de duplicidade na carga de dados.