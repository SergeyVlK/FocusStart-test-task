public interface ReadFileInterface<T> {
    boolean isEOF(); //True если достигли конца файла
    T pop(); //Прочитать и вернуть текущую строку и перейти к следующей
    T top(); //Вернуть текущую строку не переходя к следующей
}
