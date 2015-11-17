# bglogger
Blood Glucose Logger


1.1	Description 

bglogger is an application to be used by people with diabetes. It can monitor the blood glucose levels several times a day. 
In addition, the app shall log exercise, some dietary information and the medications of diabetes.

1.2	Justification 

Diabetes requires constant time for its monitoring and care. 
Type 1 diabetics and some type 2 diabetics have to monitor their blood sugars frequently.
The must keep track of the results to maintain their health. 
In the market, many blood sugar monitoring applications can be found, but it does not offer the fullset of features required for proper diabetic monitoring. 
bglogger shall provide an application with improved user interface.

1.3	Features Event Log

The application can list a log of blood glucose readings.
The blood glucose readings can have a date, time, reading <measured in mg/dl or mmol/L> and type <pre-meal, meal, post-meal, other>
Once the reading has been added it can be deleted or modified. 
The application shall list a log of meals. 
Meals include the list of food items eaten. 
Food items include description, grams of carbs, calories, and glycemic index. 
Food items show only when a meal is selected for editing, and otherwise a summary will be shown. 
Once the food item has been added to the meal it can be modified or deleted. 
Once the food item has been added to a meal it shall be saved in the database. Therefore the same item can be easily added to additional meals in the future. 
Meals also include total carbs, glycemic index and time. 
Meals shall be shown in the log as total carbs, time of meal and glycemic index. 
Once the meal has been added, it can be modified or deleted. 
The application shall list the log of exercise Exercise includes type, duration, time, and details.
Once the exercise item is added it can be deleted or modified. 
The application shall list the log of insulin doses 
Insulin doses include insulin type <lantus, novolog, etc>, method of delivery <pump, injection>, time, type <basal, bolus>, and effectiveness duration. 
The insulin effectiveness duration shall show on the log. It will encompass the other log entries included in the duration time. 
The application shall make the list of log from other medications. 
Medications shall include time, name, and dose. 
It also show as secondary items (notes) rather than standard log items. 
The report of average blood glucose will be given with timeframe. Report's method will use the HBA1c predictions.
