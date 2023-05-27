# parallel_and_distributed_GA🧬_using_Island_Model
## Project structure

![image](https://github.com/Yassine-Karimi/parallel_and_distributed_GA_using_Island_Model/assets/66490404/c729015a-8d78-48ff-add9-cbcfd8455080)


## Island Model :
is a technique for parallelizing Genetic Algorithms (GAs) that involves using multiple populations, called islands, which run concurrently and can periodically exchange individuals.

Here is a symbolic diagram to illustrate this concept:
     
![image](https://github.com/Yassine-Karimi/parallel_and_distributed_GA_using_Island_Model/assets/66490404/e9e43e3f-f45a-46ab-a041-eb235590774b)


In this diagram, we have three islands (Island 1, Island 2, Island 3), representing distinct sub-populations. Each island contains a population of individuals (Population 1, Population 2, Population 3), which are potential solutions of the genetic algorithm.

The islands operate independently, performing the standard Genetic Algorithm operations such as selection, crossover, and mutation on their own population. However, at regular intervals, individuals are migrated or exchanged between the islands to promote information sharing and diversity.
