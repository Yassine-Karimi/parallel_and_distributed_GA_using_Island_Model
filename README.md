# parallel_and_distributed_GA🧬_using_Island_Model
## Project structure

![image](https://github.com/Yassine-Karimi/parallel_and_distributed_GA_using_Island_Model/assets/66490404/c729015a-8d78-48ff-add9-cbcfd8455080)


## Island Model :
is a technique for parallelizing Genetic Algorithms (GAs) that involves using multiple populations, called islands, which run concurrently and can periodically exchange individuals.

Here is a symbolic diagram to illustrate this concept:
      +---------+       +---------+       +---------+
     |  Island 1 |       |  Island 2 |    |  Island 3 |
     +---------+        +---------+        +---------+
          |                  |                  |
          |                  |                  |
          |                  |                  |
    +--------------+   +--------------+   +--------------+
    | Population 1 |   | Population 2 |   | Population 3 |
    +--------------+   +--------------+   +--------------+
