# Management and sales platform for "Cultural Shows"

## Description

All these functions will involve adding, removing and modifying objects, which will be stored in a database, more precisely in ".dat" files.
database, more precisely in ".dat" files. This type of storage allows data to be kept permanently and without loss, and allows easy access to that data.

Good management of a cultural entertainment company requires operations on all the elements that make it up and all the functions it performs. You therefore need software that manages, adds and removes events, artists, tickets and lists and consults all the elements mentioned above.

## Detailed Programme Structure:

When you run the programme, you are presented with two options: STAFF Area and Client Area. The operations provided by the programme are grouped into other categories:

**1. STAFF Area:**
- **Consult Shows:** this category shows all the shows previously created or created by the user. They are listed in ascending order of ID.
- **Create Show:** in this category the user is asked to create the show they want. They are asked for the type of show (musical, theatre, dance or cinema), the number of artists each show will have, as well as the name, salary, the name of the show, the day of the week it will take place, the time, the capacity of the show, the duration of the show, the price to attend the show    
- **Delete Show:** in this category the user is asked to enter an ID for a listed show. After this operation, the show with the corresponding ID is deleted.
- **Add Artist:** in this category the user is asked to add a new artist to a particular show. If that artist is already in the selected show, the artist will not be added.
- **Delete Artist:** in this category the user is asked to delete an artist from a particular show. If that artist is not in the selected show, they will not be deleted.
- **Statistics:** this category displays another submenu with new options:
  - **Profit:** here you can see the profit you have made from the shows, as well as the loss, if any.
  - **Available Tickets:** here you can see how many tickets are available for a particular show.
  - **Average Ticket Price:** here the user can consult the average ticket price, calculated from an average between the total price of all tickets and the total number of tickets sold.
  - **Average salary:** here the user can consult the average salary of all the artists in all the shows, calculated from an average.
  - **Average Show Duration:** here the user can consult the average duration of all the shows, calculated from an average.
  - **Number of Shows obtained by day of the week:** here the user can consult the number of shows taking place on a day of the week chosen by the user.
  - **Number of shows obtained per person:** here the user can see the number of shows for which a particular person has bought a ticket.
  - **Best Customer:** here the user can see the person who has the most tickets.

**2.Client Area:**
- **Consult Shows:** this category shows all the shows previously created or created by the user. They are listed in ascending order by ID.
- **Consult shows by id:** in this category the user is asked to enter an ID for a show that is listed. If they enter an ID for an event that doesn't exist, they will be asked again for the id of an existing show.
- **Consult shows by artist:** in this category the user is asked to enter the name of an artist who is included in a show. If they enter the name of an artist who is not in any show, they are asked again to enter a new name.
- **Tickets:** in this category another sub-menu is displayed with new options: 
- **Buy Ticket:** in this category the user is allowed to buy tickets for a show of their choice. The user enters the ID of a show that is listed, then enters the number of tickets they want to buy, as well as the name, queue and seat of the ticket holder.
- **Seats Occupied:** in this category, the user is asked to enter the ID of the show they want to see, so they can see the seats already occupied.
