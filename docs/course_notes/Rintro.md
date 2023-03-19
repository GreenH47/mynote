# R intro
## Variables and Assignments
Variables are stored using the assignment operator <-, : 
```r
a<- 1
b<- 2
c<- a+b
c # 3
```
  
Please do no use the '=' sign to assign values to variables. It is considered bad practice by the R community.  
## Managing your environment
You can use rm to delete objects you no longer need `rm(x)`  
If you have lots of things in your environment and want to delete all of them, you can pass the results of ls to the rm function `rm(list = ls())`  
Clean up your working environment by deleting the mass and age variables.`rm(age,mass)`  
## R Packages
 what packages are installed by typing `installed.packages()`   
 install packages by typing `install.packages("packagename")`  
 update installed packages by typing `update.packages()`  
 remove a package with `remove.packages("packagename")`  
 make a package available for use with `library(packagename)`    
 
##  Data Types and data structures
 
 Everything in R is an object.   
 <mark style="background: #0000CD;">R has six atomic (data of a single type) vector types</mark>.
 + character: "a", "swc"  
 + numeric: 2, 15.5  
 + integer: 2  
 + logical: TRUE, FALSE  
 + complex: 1+4i (complex numbers with real and imaginary parts)

R has many data structures. These include : atomic vector; list; matrix; data frame; factors  
class() - what kind of object is it (high-level)?  
typeof() - what is the object's data type (low-level)?  
length() - how long is it? What about two dimensional objects?  
attributes() - does it have any metadata?  

```r
x <- "dataset"
y <- 555.55
z <- as.integer(y)
typeof(x) # character
typeof(y) # double
typeof(z) # integer

attributes(x) # NULL
attributes(y) # NULL
attributes(z) # NULL
```

## Vectors
A vector is a collection of elements that are most commonly of mode character, logical, integer or numeric.  
You can create an empty vector with vector().  
By default the mode is logical. You can be more explicit as shown in the examples below.   
It is more common to use direct constructors such as character(), numeric(), etc.
```r
vector() # an empty 'logical' (the default) vector
vector("character", length = 5) # a vector of mode 'character' with 5 elements
```  
Using TRUE and FALSE will create a vector of mode logical. and using quoted text will create a vector of mode character.  
```r
poke <- c("Squirtle", "Charmander", "Bulbasaur")
typeof(poke) # character
length(poke) # 3
class(poke)  # character
str(poke)    # "Squirtle" "Charmander" "Bulbasaur"
```
Adding Elements  
The function c() (for combine) can also be used to add elements to a vector.  
```r
poke<-c(poke, "Pikachu")
poke # "Squirtle"   "Charmander" "Bulbasaur"  "Pikachu"
```  

Vectors from a sequence of numbers.   
You can create vectors as a series of numbers.  
```r
series <- 1:10
series #  1  2  3  4  5  6  7  8  9 10
seq(10) # 1  2  3  4  5  6  7  8  9 10
seq(from = 1, to = 10, by = 0.1)
#  [1]  1.0  1.1  1.2  1.3  1.4  1.5  1.6  1.7  1.8  1.9  2.0  2.1  2.2  2.3  2.4  2.5  2.6  2.7  2.8
# [20]  2.9  3.0  3.1  3.2  3.3  3.4  3.5  3.6  3.7  3.8  3.9  4.0  4.1  4.2  4.3  4.4  4.5  4.6  4.7
# [39]  4.8  4.9  5.0  5.1  5.2  5.3  5.4  5.5  5.6  5.7  5.8  5.9  6.0  6.1  6.2  6.3  6.4  6.5  6.6
# [58]  6.7  6.8  6.9  7.0  7.1  7.2  7.3  7.4  7.5  7.6  7.7  7.8  7.9  8.0  8.1  8.2  8.3  8.4  8.5
# [77]  8.6  8.7  8.8  8.9  9.0  9.1  9.2  9.3  9.4  9.5  9.6  9.7  9.8  9.9 10.0
```
Naming a vector.   
The elements of a vector can be given names using, names()  
```r
temperature <- c(30, 29, 20, 15, 40)
names(temperature) <- c("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
```
Vector index 
The values in a vector can be extracted via declaring an index inside a single square bracket "[]" operator.  
```r
temperature[1] # The first value in the temperature vector.
# Monday
# 30
```
Unlike Python, R index starts from 1 rather than 0. Also the square bracket operator returns another vector rather than just individual members. `temperature[1]` returned a vector slice containing a single member.  
```r
temperature[1:3] #  Monday   Tuesday Wednesday 
# 30        29        20 

temperature["Wednesday"] # Wednesday 20

temperature[c("Wednesday","Friday")] # Wednesday 20 Friday 40

temperature[11] # <NA> NA
```
## challenge
```r
 Challenge 9: Create a vector for average temperature in Melbourne for each month.
# Jan    Feb    Mar    Apr    May    Jun    Jul    Aug    Sep    Oct    Nov    Dec
# °C    21    21    19    17    14    11    10    11    13    15    17    19

temp_month<-c(21, 21, 19, 17, 14, 11, 10, 11, 13, 15, 17, 19)
names(temp_month)<-month.abb
temp_month

# Challenge 10: Find out which month has the maximum temperature.
temp_month[which.max(temp_month)] # Jan 21


#Challenge 11: Find out the temperature difference between the month with maximum 
# temperature and the month with minimum temperature.
temp_month[[which.max(temp_month)]]- temp_month[[which.min(temp_month)]] # 11
```
## Factors
Factors usually look like character data, but are typically used to represent categorical information.
```r
# create ses variable
ses <- c("low", "middle", "low", "high", "low", "low", "low", "middle", "low", "middle", "middle", "middle", "middle", "middle")
ses.f<-factor(ses)

# Check levels
levels(ses.f) # "high"   "low"    "middle"
```
The problem is that the levels are ordered according to the alphabetical order of the categories of `ses`. Thus, "high" is the lowest level of `ses.f`, "low" is the middle level and  "middle" is the highest level. To fix the ordering we need to use the levels argument   
to indicate the correct ordering of the categories. Let's create `ses.f` with the correct order of categories.  
```r
ses.f <- factor(ses, levels = c("low", "middle", "high")) # "high"   "low"    "middle"
```
We can also generate factor variable from numeric data by specifying labels using the labels argument.  
```r 
# Challenge 1: Create a factor variable for type as type.f and label 0 as "private" and one as "public".

# from a numaric vector
type<-c(1,0,0,0,1,1,0,1)

type.f<-factor(type, levels = c ("1","0"), labels = c("private", "public"))
type.f 

# [1] private public  public  public  private private public  private
# Levels: private public
```
**Ordered** factor variables   
can be created by using the function 'ordered'. This function has the same arguments as the factor function. To create an ordered factor variable called `ses.order` based on the variable `ses.`  `ses.order <- ordered(ses, levels = c("low", "middle", "high"))`  

Adding and dropping levels   
Below we will add an element from a new level ("very.high") to `ses.f` our existing factor variable,   
```r
# first add the new level, "very.high", to the factor variable ses.f)
ses.f <- factor(ses.f, levels = c(levels(ses.f), "very.high"))
ses.f[15] <- "very.high"
ses.f
#  [1] low    middle low    high   low    low    low    middle low    middle middle middle middle middle <NA>  
# Levels: high low middle
```
Dropping a level of a factor variable  
The simplest way is to first remove all the elements within the level. to be removed and then to re-declare the variable to be a factor variable.  
```r
# removing the level of "very.high" from the ses.f variable.
ses.f.new <- ses.f[ses.f != "very.high"]
ses.f.new
# [1] low    middle low    high   low    low    low    middle low    middle middle middle middle middle <NA>  
# Levels: high low middle
ses.f.new <- factor(ses.f.new)
ses.f.new
# [1] low    middle low    high   low    low    low    middle low    middle middle middle middle middle <NA>  
# Levels: high low middle
```
## Matrix
In R matrices are an extension of the numeric or character vectors. They are not a separate type of object but merely an atomic vector with dimensions; the number of rows and columns  
```r
m <- matrix(1:6, nrow = 2, ncol = 2)
m
# [,1] [,2]
# [1,]    1    3
# [2,]    2    4
dim(m) # 22
typeof(m) # integer
class(m) # matrix
```
Matrices in R are filled column-wise. You can also fill data by row with argument by row. Another way is to bind vectors using `cbind()` and `rbind()`.  
```r
matrix_example <- matrix(0, ncol=6, nrow=3)
length(matrix_example) # 18
```  

```r
# Challenge 4: Consider the R output of the matrix below:

# [,1] [,2]
# [1,]    4    1
# [2,]    9    5
# [3,]   10    7

matrix(c(4, 9, 10, 1, 5, 7), nrow = 3)
#[,1] [,2]
#[1,]    4    1
#[2,]    9    5
#[3,]   10    7

matrix(c(4, 1, 9, 5, 10, 7), ncol = 2, byrow = TRUE)
#[,1] [,2]
#[1,]    4    1
#[2,]    9    5
#[3,]   10    7

matrix(c(4, 1, 9, 5, 10, 7), nrow = 3)
#[,1] [,2]
#[1,]    4    5
#[2,]    1   10
#[3,]    9    7

matrix(c(4, 9, 10, 1, 5, 7), ncol = 2, byrow = TRUE)
#[,1] [,2]
#[1,]    4    9
#[2,]   10    1
#[3,]    5    7
```

What is the difference between `cbind()` and `rbind()`.  
```r
x <- 1:3
y <- 10:12

cbind(x,y)
#   x  y
# [1,] 1 10
# [2,] 2 11
# [3,] 3 12
# Binds by column
rbind(x,y)
# [,1] [,2] [,3]
# x    1    2    3
# y   10   11   12
# Binds by row
```

## List
the contents of a list are not restricted to a single mode and can encompass any mixture of data types. Lists are sometimes called generic vectors, because the elements of a list can by of any R object, even lists containing further lists. This property makes them fundamentally different from atomic vectors.  
A list is a special type of vector. Each element can be a different type. Create lists using `list()` or coerce other objects using `as.list()`.  
```r
x <- list(1, "a", TRUE, 1+4i)
x
# [[1]]
# [1] 1

# [[2]]
# [1] "a"

# [[3]]
# [1] TRUE

# [[4]]
# [1] 1+4i

x <- 1:10
x <- as.list(x)
x
# [[1]]
# [1] 1

# [[2]]
# [1] 2

# [[3]]
# [1] 3

# [[4]]
# [1] 4

# [[5]]
# [1] 5

# [[6]]
# [1] 6

# [[7]]
# [1] 7

# [[8]]
# [1] 8

# [[9]]
# [1] 9

# [[10]]
# [1] 10

# Elements of lists can have names. 

xlist <- list(a = "Karthik Ram", b = 1:10, data = head(iris))
xlist
# $a
# [1] "Karthik Ram"

# $b
# [1]  1  2  3  4  5  6  7  8  9 10

# $data
# Sepal.Length Sepal.Width Petal.Length Petal.Width Species
# 1          5.1         3.5          1.4         0.2  setosa
# 2          4.9         3.0          1.4         0.2  setosa
# 3          4.7         3.2          1.3         0.2  setosa
# 4          4.6         3.1          1.5         0.2  setosa
# 5          5.0         3.6          1.4         0.2  setosa
# 6          5.4         3.9          1.7         0.4  setosa

length(xlist) # 3
str(xlist)
# List of 3
# $ a   : chr "Karthik Ram"
# $ b   : int [1:10] 1 2 3 4 5 6 7 8 9 10
# $ data:'data.frame':    6 obs. of  5 variables:
#   ..$ Sepal.Length: num [1:6] 5.1 4.9 4.7 4.6 5 5.4
# ..$ Sepal.Width : num [1:6] 3.5 3 3.2 3.1 3.6 3.9
# ..$ Petal.Length: num [1:6] 1.4 1.4 1.3 1.5 1.4 1.7
# ..$ Petal.Width : num [1:6] 0.2 0.2 0.2 0.2 0.2 0.4
# ..$ Species     : Factor w/ 3 levels "setosa","versicolor",..: 1 1 1 1 1 1
```
You can extract an element of a list using `$` operator with the element's name. `xlist$b #  [1]  1  2  3  4  5  6  7  8  9 10`   The $ operator is used to extract elements of a list or data frame by literal name. It's semantics are similar to that of `[[` 
The `[` operator always returns an object of the same class as the original. It can be used to select multiple elements of an object  
The `[[` operator is used to extract elements of a list or a data frame. It can only be used to extract a single element, and the class of the returned object will not necessarily be a list or data frame


```r
class(xlist[2])# list
class(xlist[[2]]) # integer
class(xlist$b) # integer
```

## Data Frame
A data frame is a very important data type in R. Its pretty much the de facto data structure for most tabular data and what we use for statistics. Data frames can have additional attributes such as `rownames()`, which can be useful for annotating data, like `subject_id` or `sample_id`. But most of the time they are not used. Some additional information on data frames:
+ Rownames are usually 1, 2,...
+ Can convert to a matrix with `data.matrix()` (preferred) or `as.matrix()`  
+ Can also create with `data.frame()` function  
+ Find the number of rows and columns with `nrow(dat)` and `ncol(dat)`, respectively.

```r
# To create data frames by hand
dat <- data.frame(id = letters[1:10], x = 1:10, y = 11:20)
dat
#     id x  y
# 1   a  1 11
# 2   b  2 12
# 3   c  3 13
# 4   d  4 14
# 5   e  5 15
# 6   f  6 16
# 7   g  7 17
# 8   h  8 18
# 9   i  9 19
# 10  j 10 20
```

```r
# * head() - shown first 6 rows
# * tail() - show last 6 rows
# * dim() - returns the dimensions
# * nrow() - number of rows
# * ncol() - number of columns
# * str() - structure of each column
# * names() - shows the names attribute for a data frame, which gives the column names.
```

## Data frame index
A data frame, much like a matrix, has two dimensions, rows and columns. To index a data frame (or a matrix), we use brackets in R next to the object, like so, `iris[i, j]`, where i denotes the rows that you want, and j is the columns.
```r
# Extract the first ten rows of the iris dataset.
iris[1:10,]
##    Sepal.Length Sepal.Width Petal.Length Petal.Width Species
## 1           5.1         3.5          1.4         0.2  setosa
## 2           4.9         3.0          1.4         0.2  setosa
## 3           4.7         3.2          1.3         0.2  setosa
## 4           4.6         3.1          1.5         0.2  setosa
## 5           5.0         3.6          1.4         0.2  setosa
## 6           5.4         3.9          1.7         0.4  setosa
## 7           4.6         3.4          1.4         0.3  setosa
## 8           5.0         3.4          1.5         0.2  setosa
## 9           4.4         2.9          1.4         0.2  setosa
## 10          4.9         3.1          1.5         0.1  setosa

# We can also extract individual columns of a data frame with the $ operator using column name. 
iris$Species

# Challenge 8: Find out how many rows of data in iris dataset where Species is setosa.


nrow(iris[iris$Species=="setosa",]) # 50
```

## Adding columns and rows in data frame
We learned that the columns in a data frame were vectors,  so that our data are consistent in type throughout the column. As such, if we want to add a new column, we need to start by making a new vector:
```r
new1<-c(1:3)
new2<-1 
cars[1:2]
cars<-rbind(cars,new1)
cars<-rbind(cars,new2)
```

## Read data 
na.strings converts all missing data to na.  
```r
ti_train<- read.csv("titanic_train_week1.csv",na.strings=c("NA","NaN", ""), header = TRUE, sep=",")
ti_test<- read.csv("titanic_test_week1.csv",na.strings=c("NA","NaN", ""), header = TRUE, sep = ",")
```
how much missing data are we dealing with? Using the column sums and the is.na() function, we get the amount of NAs we have in for each variable.  
```r
colSums(is.na(ti_train))
# There are 177 missing 'Age' observations, 687 missing 'Cabin' observations and 2 missing 'Embarked' observations. 
colSums(is.na(ti_test))
# There is 1 missing 'Fair' observation, 327 missing 'Cabin' observations.
```
Knowing what you are dealing with is important. NA means 'not available' and NAN means 'not a number', handle those value before further operation `mean(ti_train$Age) # NA`   

### 1 Remove all the rows with missing data
+ We can use the complete.cases function. This will return a vector that has no missing values `ti_train[!complete.cases(ti_train),]`  
+ To create a new data set with no missing data we use na.omit() `ti_train_full<-na.omit(ti_train)`  
+ there are no rows with na's. `ti_train_full[!complete.cases(ti_train_full),]`  
+ omitting all na's and the cabin data which is largly missing
### 2 Remove the variables with missing data
We could choose to exclude the variables with the most amount of missing data. Then we would move forward more sophisticated methods. Since ~68% of the Cabin data is missing. It is a good idea at this level to exclude it. We simple make a new dataframe excluding the cabin data.  
```r
train_sml<-data.frame(ti_train$PassengerId, ti_train$Survived, ti_train$Pclass, ti_train$Name, ti_train$Sex, ti_train$Age, ti_train$SibSp, ti_train$Ticket, ti_train$Fare, ti_train$Embarked)
test_sml<-data.frame(ti_test$PassengerId, ti_test$Pclass, ti_test$Name, ti_test$Sex, ti_test$Age, ti_test$SibSp, ti_test$SibSp, ti_test$Parch, ti_test$Ticket, ti_test$Fare, ti_test$Embarked)
```

