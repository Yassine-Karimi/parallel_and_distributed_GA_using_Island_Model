# parallel_and_distributed_GA🧬_using_Island_Model

<h1 style="background-color:orange;font-family:newtimeroman;font-size:350%;text-align:center;border-radius: 15px 50px;">Table Of Content</h1>


* [1. Introduction](#1)   
* [2. Project structure](#2)
* [3. Model Architecture](#3)    
* [4. Results](#4) 
     

## 1 Introduction

The Island Model is a widely used approach in the field of evolutionary computation, specifically in Genetic Algorithms (GA). It combines the principles of parallelism and distributed computing to enhance the exploration and exploitation capabilities of traditional GAs. By dividing the population into subpopulations or islands, each evolving independently, the Island Model introduces a novel level of diversity and allows for efficient global search within a complex optimization problem.

Genetic Algorithms are inspired by the process of natural evolution, where a population of individuals undergoes genetic operations such as selection, crossover, and mutation to improve their fitness over generations. However, in certain cases, traditional GAs may suffer from premature convergence or become trapped in local optima, limiting their ability to find the optimal solution.

To address these limitations, the Island Model introduces parallelism by creating multiple subpopulations or islands, each representing a potential solution space. These islands operate concurrently and undergo genetic operations independently, promoting exploration within each island. This parallel processing allows for faster convergence and increases the chances of finding the global optimum.

The islands are interconnected through a migration mechanism that facilitates the exchange of individuals between them. At regular intervals or based on predefined migration policies, individuals migrate from one island to another, bringing new genetic information and injecting diversity into different subpopulations. This migration helps prevent stagnation and promotes the sharing of beneficial genetic material among islands.

The Island Model offers several advantages over traditional GAs. Firstly, it improves the exploration-exploitation trade-off by providing a balance between the exploitation of local optima within islands and the exploration of new regions through migration. Secondly, it enhances the robustness and scalability of the GA, allowing for the optimization of larger and more complex problems. Additionally, the Island Model can benefit from the availability of distributed computing resources, leveraging multiple machines or processors to parallelize the computations.

In summary, the parallel and distributed GA using the Island Model is a powerful approach for optimization problems. By exploiting parallelism and migration mechanisms, it enables efficient exploration of the search space, facilitates sharing of genetic information, and improves the chances of finding the global optimum. This approach has been successfully applied in various domains, including engineering, finance, bioinformatics, and more, demonstrating its effectiveness in solving complex real-world problems.

## 2 Project structure

![image](https://github.com/Yassine-Karimi/parallel_and_distributed_GA_using_Island_Model/assets/66490404/b46e7894-09c5-4669-b339-f613b05b5db1)

## 3 Model Architecture (Island Model) :
Island Model is a technique for parallelizing Genetic Algorithms (GAs) that involves using multiple populations, called islands, which run concurrently and can periodically exchange individuals.

Here is a symbolic diagram to illustrate this concept:
     
![image](https://github.com/Yassine-Karimi/parallel_and_distributed_GA_using_Island_Model/assets/66490404/e9e43e3f-f45a-46ab-a041-eb235590774b)


In this diagram, we have three islands (Island 1, Island 2, Island 3), representing distinct sub-populations. Each island contains a population of individuals (Population 1, Population 2, Population 3), which are potential solutions of the genetic algorithm.

The islands operate independently, performing the standard Genetic Algorithm operations such as selection, crossover, and mutation on their own population. However, at regular intervals, individuals are migrated or exchanged between the islands to promote information sharing and diversity.

## 4 Results
As an example of applying this implementation we gonna choose a string target, let it be "Bonjour SDIA" and the result is :
![image](https://github.com/Yassine-Karimi/parallel_and_distributed_GA_using_Island_Model/assets/66490404/2659dd64-446f-45f8-8899-baca71fa5062)
