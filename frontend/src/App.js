import './App.css';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import ListBoardComponent from './components/ListBoardComponent';
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from "./components/FooterComponent";
import CreateBoardComponent from './components/CreateBoardComponent';
import ReadBoardComponent from './components/ReadBoardComponent';

function App() {
    return (
        <div>
            <Router>
                <HeaderComponent/>
                    <div className="container">
                        <Switch>
                            <Route path="/" exact component={ListBoardComponent}/>
                            <Route path="/board" component={ListBoardComponent}/>
                            <Route path="/create-board/:id" component={CreateBoardComponent}/>
                            <Route path="/read-board/:id" component={ReadBoardComponent} />
                        </Switch>
                    </div>
                <FooterComponent/>
            </Router>
        </div>
    );
}

export default App;
