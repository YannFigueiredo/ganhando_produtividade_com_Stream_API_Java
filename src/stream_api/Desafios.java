package stream_api;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Desafios {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        List<Integer> numerosOrdenados = new ArrayList<>(numeros);
        System.out.println("1-NÚMEROS ORDENADOS:");
        numerosOrdenados.sort((n1, n2) -> Integer.compare(n1, n2));
        numerosOrdenados.forEach(System.out::println);

        System.out.println("\n2-SOMA DOS NÚMEROS PARES:");
        System.out.println(
                numeros.stream().filter(n -> n % 2 == 0)
                        .mapToInt(n -> n)
                        .sum()
        );

        System.out.println("\n3-VERIFICAR SE NÚMEROS SÃO POSITIVOS:");
        numeros.forEach(
                n -> System.out.println(
                        String.format("O %d é positivo? %b", n, n > 0)
                )
        );

        List<Integer> numerosPares = new ArrayList<>(numeros);
        System.out.println("\n4-REMOVER OS VALORES ÍMPARES:");
        numerosPares.removeIf(n -> n % 2 != 0);
        numerosPares.forEach(System.out::println);

        System.out.println("\n5-MÉDIA DOS NÚMEROS MAIORES QUE 5:");
        System.out.println(
                numeros.stream().filter(n -> n > 5)
                        .mapToInt(n -> n)
                        .average().orElse(Double.NaN)
        );

        System.out.println("\n6-VERIFICAR SE A LISTA TÊM ALGUM NÚMERO MAIOR QUE 10:");
        System.out.println(numeros.stream().anyMatch(n -> n > 10));

        System.out.println("\n7-ENCONTRAR O 2º MAIOR NÚMERO DA LISTA:");
        List<Integer> numerosOrdenadosList = numeros.stream()
                .distinct() //Remove duplicados
                .sorted((n1, n2) -> Integer.compare(n1, n2)) //Ordena sem alterar a lista orginal
                .toList();
        numerosOrdenadosList.forEach(System.out::println);
        System.out.println(
                "Segundo maior: " + numerosOrdenadosList.get(numerosOrdenadosList.size() - 2)
        );

        System.out.println("\n8-SOMAR OS DÍGITOS DOS NÚMEROS DA LISTA:");
        //Mapeando 'numeros' cada elemento da lista é convertido em uma lista de chars, e essa lista de
        // chars é mapeada para transformar cada elemento em um int para então somar
        //Com isso somamos o resultado de cada soma da lista de chars otendo assim a soma dos dígitos
        // da lista original
        System.out.println(
            numeros.stream().map(
                n -> String.valueOf(n).chars().map(c -> Character.getNumericValue(c)).sum()
            ).mapToInt(n -> n).sum()
        );
    }
}
