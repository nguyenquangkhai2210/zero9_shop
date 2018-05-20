<!doctype html>
<html lang="en">

    <head>
        <title>Order Page</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->

        <link rel="stylesheet" href="css/bootstrap.css">

    </head>

    <body>
        <div class="col-lg-12  mr-0">
            <nav class="navbar navbar-expand-lg navbar-light col-lg-12" style="background-color: #e3f2fd;">
                <button class="navbar-toggler col-lg-12" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                    Menu
                </button>
                <div class="collapse navbar-collapse col-lg-12" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="navbar-brand" href="#">Zero9 Shop</a>
                        </li>
                        <li class="nav-item d-block d-sm-none ">
                            <a class="nav-link" href="#">Dashboard </a>
                        </li>
                        <li class="nav-item d-block d-sm-none active">
                            <a class="nav-link" href="#">Order</a>
                        </li>
                        <li class="nav-item d-block d-sm-none">
                            <a class="nav-link" href="#">Customer</a>
                        </li>
                        <li class="nav-item d-block d-sm-none ">
                            <a class="nav-link" href="#">Employee</a>
                        </li>
                        <li class="nav-item d-block d-sm-none">
                            <a class="nav-link" href="#" >Product</a>
                        </li>
                        <li class="nav-item d-block d-sm-none">
                            <a class="nav-link" href="#">Promotion</a>
                        </li>
                    </ul>
                    <button type="button" class="btn btn-primary col-lg-1"> Notification
                        <span class="badge badge-light">10</span>
                    </button>
                    <div class="btn-group text-center col-lg-2">
                        <button type="button" class="btn btn-secondary dropdown-toggle  col-lg-12" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Welcome , <%
                                out.println(session.getAttribute("username"));
                            %>
                        </button>
                        <form method="GET" action="MainControllerServlet">
                            <div class="dropdown-menu dropdown-menu-right col-lg-11 ml-3 text-center">
                                <button class="dropdown-item" type="button">View Profile</button>
                                <button class="dropdown-item" type="button" >Change Password</button>
                                <button class="dropdown-item" type="submit" name="btAction" value="Logout">Logout!                                
                                </button>
                            </div>
                        </form>

                    </div>
                </div>

            </nav>
        </div>
        <form class="form-inline d-flex justify-content-end mt-2 mr-4 mb-2">
            <input class="form-control mr-sm-3  col-8 col-lg-1" type="search" placeholder="Search ID" aria-label="Search">
            <button class="btn btn-outline-primary my-2 my-sm-0 ml-1" type="submit">Search</button>
        </form>
        <div class="row">
            <div class="col-lg-1 bg-light ml-3 pl-0 pr-0 d-none d-xl-block">
                <div class="col-lg-12 pr-0" style="height: 53em;">
                    <div class="list-group">
                        <form action="MainControllerServlet" method="POST">
                            <a href="#" class="list-group-item list-group-item-action list-group-item-light">Dashboard</a>
                            <a href="#" class="list-group-item list-group-item-action list-group-item-light active">Order</a>
                            <a href="#" class="list-group-item list-group-item-action list-group-item-light">Customer</a>
                            <a href="#" class="list-group-item list-group-item-action list-group-item-light ">Employee</a>
                            <button class="list-group-item list-group-item-action list-group-item-light" value ="Product" type="submit" name="btAction">Product</button>
                            <button class="list-group-item list-group-item-action list-group-item-light btn" >Promotion</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-10 ml-3 mr-0 pl-0 pr-0">
                <div class="col-lg-12 table-responsive pl-0 pr-0">
                    <table class="table table-bordered table-hover text-center">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Date</th>
                                <th scope="col">Username</th>
                                <th scope="col">Amount</th>
                                <th scope="col">Status</th>
                                <th scope="col">Detail</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>12:00 PM 20/04/18</td>
                                <td>A</td>
                                <td>300$</td>
                                <td>
                                    <span class="badge badge-success">Success</span>
                                </td>
                                <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>B</td>
                            <td>200$</td>
                            <td>
                                <span class="badge badge-danger">Reject</span>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>C</td>
                            <td>250$</td>
                            <td>
                                <button type="button" class="btn btn-outline-success btn-sm">Approve</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Reject</button>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>C</td>
                            <td>250$</td>
                            <td>
                                <button type="button" class="btn btn-outline-success btn-sm">Approve</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Reject</button>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>C</td>
                            <td>250$</td>
                            <td>
                                <button type="button" class="btn btn-outline-success btn-sm">Approve</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Reject</button>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>C</td>
                            <td>250$</td>
                            <td>
                                <button type="button" class="btn btn-outline-success btn-sm">Approve</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Reject</button>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>C</td>
                            <td>250$</td>
                            <td>
                                <button type="button" class="btn btn-outline-success btn-sm">Approve</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Reject</button>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>C</td>
                            <td>250$</td>
                            <td>
                                <button type="button" class="btn btn-outline-success btn-sm">Approve</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Reject</button>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>C</td>
                            <td>250$</td>
                            <td>
                                <button type="button" class="btn btn-outline-success btn-sm">Approve</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Reject</button>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>C</td>
                            <td>250$</td>
                            <td>
                                <button type="button" class="btn btn-outline-success btn-sm">Approve</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Reject</button>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>12:00 PM 20/04/18</td>
                            <td>C</td>
                            <td>250$</td>
                            <td>
                                <button type="button" class="btn btn-outline-success btn-sm">Approve</button>
                                <button type="button" class="btn btn-outline-danger btn-sm">Reject</button>
                            </td>
                            <td>
                        <li style="list-style-type: none">
                            <svg id="i-plus" viewBox="0 0 32 32" width="16" height="16" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round"
                                 stroke-width="2">
                            <path d="M16 2 L16 30 M2 16 L30 16" />
                            </svg>
                        </li>
                        </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>

</html>