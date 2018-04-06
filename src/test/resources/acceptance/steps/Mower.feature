Feature: Pivot the mower

	Scenario Outline: Pivot the mower with difference instruments

		Given a lawn with coordinate of highest right side <limitX>,<limitY>
 	    And I place the mower inside of the lawn with coordinate <x>,<y>,<direction>
		When  I pivot the mower with a serie of instruments <instruments>
		Then mover communicate his coordinate at the end of instruments <endX>,<endY>,<endDirection>


		Examples:
			| limitX | limitY | 	x 	| 	y 	| direction | instruments |	endX	|	endY	|	endDirection |
			| 	5 	 | 	  5	  | 	1 	| 	2 	| 	North	| GAGAGAGAA   |	1		|	3		|	North		 |
			| 	5 	 | 	  5	  | 	3 	| 	3 	| 	East	| AADAADADDA  |	5		|	1		|	East		 |



