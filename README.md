# ManualCollections
Данный проект представляет собой попытку реализовать "вручную", без использования Collections Framework наиболее часто используемые контейнеры, 
такие как массив с изменяющимся размером, связный список, множество и ассоциативный массив

Он не создавался как попытка заменить уже существующий Collections. Я всего лишь хотел повторить базовую функциональность наиболее часто используемых классов из Collections, сохранив их внутреннюю логику: массив изменяющегося размера построен на базе массивов. Список использует связный список для хранения данных в памяти. Множество и ассоциативный массив используют хэширование для ускорения поиска элементов. Также они поддерживают перехэширование для более рационального использования памяти.
