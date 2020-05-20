var app1 = document.getElementById('app1');


//-------------- 1. Inline ----------------//
ReactDOM.render(<h1>Hello world !</h1>, app1);





/*
//-------------- 2. Function ----------------//
function Funct1(props){
    return (<div>
            <h1>Function Example - {props.name}</h1>
            <ul>
            <li>1. Option 1</li>
            <li>2. Option 2</li>
            <li>3. Option 3</li>
            </ul>
    </div>)
}

ReactDOM.render(<Funct1 name="My Test function" />, app1);
*/

/*
//-------------- 3. Tick ----------------//

function tick() {
    const element = (
        <div>
        <h1>Hello, world!</h1>
        <h2>It is {new Date().toLocaleTimeString()}.</h2>
        </div>
);
    ReactDOM.render(element, app1);
}

setInterval(tick, 1000);
*/

/*
//-------------- 4. Class Function ----------------//

class MyClass1 extends React.Component{
    constructor(props){
        super(props);

        this.state = {name:'', desc:'', price:"0.00"};
        //todo
    }
    componentDidMount() {
        //Changing state values
        this.setState({name: 'Tea', desc: 'Tea description', price: "40.45"});
    }
    render(){
        return <div>
        <h2>Propertise - {this.props.name} - {this.props.desc} :: {this.props.price}</h2>
        <h2>State changes - {this.state.name} - {this.state.desc} :: {this.state.price}</h2>
        </div>
    }
}

ReactDOM.render(<MyClass1 name="A" desc="D" price="29.36" />, app1);
*/


/*
//-------------- 5.1 Events 1----------------//
class MyEvent1 extends React.Component{
 constructor(props) {
     super(props);

     //this.buttonClick = this.buttonClick.bind(this);
 }
    buttonClick(e){
        alert('Clicked');
        console.log('button clicked!');
    }

    render(){
         return <div>
        <button onClick={this.buttonClick.bind(this)}>Click here</button>
        </div>
    }
}

ReactDOM.render(<MyEvent1 />, app1);

*/


/*
//-------------- 5.2 Events 2----------------//
class MyEvent2 extends React.Component {
    constructor(props) {
        super(props);

        this.state = {age: 0};

        this.upEvent = this.upEvent.bind(this);
        this.downEvent = this.downEvent.bind(this);
    }

    upEvent(props) {
        console.log('up event');

        var age = parseInt(this.state.age) + 1;
        this.setState({age: age});
    }

    downEvent(props) {
        console.log('down event');

        var age = parseInt(this.state.age) - 1;
        this.setState({age: age});
    }

    render(){
        return <div>
            <button onMouseMove={this.upEvent}>Up</button>
            <p>Age : {this.state.age}</p>
            <button onMouseMove={this.downEvent}>Down</button>
            </div>
    }
}

ReactDOM.render(<MyEvent2 />, app1);

*/

/*
//-------------- 5.3 Events ----------------//
class Toggle extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isToggleOn: true};

        // This binding is necessary to make `this` work in the callback
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {

        / * if(state.isToggleOn){
            isToggleOn = false;
        }else
            isToggleOn=true;

        this.setState({isToggleOn:isToggleOn});
        * /
        this.setState(state => ({
            isToggleOn: !state.isToggleOn
        }));
    }

    render() {
        return (
            <button onClick={this.handleClick}>
        {this.state.isToggleOn ? 'ON' : 'OFF'}
    </button>
    );
    }
}

ReactDOM.render(<Toggle />, app1);

*/

/*
//-------------- 6 Conditional Rendering ----------------//
function UserGreeting(props){
    return <h1>Welcome back !</h1>
}
function GuestGreeting(props){
    return <h1>Please login in !</h1>
}

function Greeting(props){
    const isLoggedIn = props.isLoggedIn;

    if(isLoggedIn){
        return <UserGreeting />
    }else {
        return <GuestGreeting / >
    }
}
ReactDOM.render(<Greeting isLoggedIn={true} />,  app1);
*/

/*
//------------------ 7 List and Keys -----------------//
function NumberList(props) {
    const numbers = props.numbers;
    const listItems = numbers.map((number) =>
        <li key={number.toString()}>
            {number}
        </li>
        );

    / * const listItems = numbers.map(function(n){
       return <li>{n}</li>
    }); * /

    return (
        <ul>{listItems}</ul>
        );
}

const numbers = [1, 2, 3, 4, 5];
ReactDOM.render(<NumberList numbers={numbers} />, app1);

*/


/*
//------------------ 8. Forms ------------------//

class NameForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {name: '', email:''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        var name = event.target.name;
        var value = event.target.value;

        console.log(name +':'+value);

        this.setState({[name]: value});
    }

    handleSubmit(event) {
        alert('A form was submitted: ' + this.state.name + '::'+this.state.email);
        event.preventDefault();
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                    Name: <input type="text" name="name" value={this.state.name} onChange={this.handleChange} />
                </label>

                <label>
                    Email: <input type="text" name="email" value={this.state.email} onChange={this.handleChange} />
                </label>

                <input type="submit" value="Submit" />
                </form>
                );
                }
}

ReactDOM.render(<NameForm />, app1);

*/

/*
//------------------ 9. Containment ------------------//
function Left(){
    return <div><p>Left Panel</p></div>
}
function Right(){
    return <div><p>Right Panel</p></div>
}

function Panel(){
    return <div>
           {<Left />}
            {<Right />}
            </div>
}

ReactDOM.render(<Panel />, app1);

*/