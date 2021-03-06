package pt.c07bd.s01basico.s02hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App03ConsultaTaxonomia
{
      public static void main(String argumentos[])
      {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            Connection conexao = DriverManager.getConnection(
                    "jdbc:hsqldb:file:db/hsqldb/biblioteca;shutdown=true", "SA", "");

          Statement comando = conexao.createStatement();

          // aciona metodo que executa comando SQL (este metodo e especialmente usado para acesso)
          ResultSet resultado = comando.executeQuery("SELECT Categoria, Superior FROM Taxonomia");

          // lista o conteudo da tabela no console
          boolean temConteudo = resultado.next();
          while (temConteudo)
          {
            String categoria= resultado.getString("Categoria"),
                   superior = resultado.getString("Superior");
            System.out.println(categoria + "; " + superior);
            temConteudo = resultado.next();
          }

          comando.close();

          conexao.close();

        } catch (ClassNotFoundException erro) {
          System.out.println(erro.getMessage());
        } catch (SQLException erro) {
          System.out.println("Erro no SQL: " + erro.getMessage());
        }
      }

}
