import React, {Component} from 'react';
import BoardService from "../service/BoardService";

class ReadBoardComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            board: {}
        }
    }

    componentDidMount() {
        BoardService.getOneBoard(this.state.id).then(res => {
            console.log(res.data);
            this.setState({board: res.data})
        });
    }

    returnBoardType(typeNo) {
        let type = null;

        switch (typeNo) {
            case "1":
                type = "자유게시판";
                break;
            case "2":
                type = "질문과 답변";
                break;
            default:
                type = "타입 미지정";
                break;
        }

        return (
            <div className="row">
                <label>Board Type : </label> {type}
            </div>
        );
    }

    goToList() {
        this.props.history.push('/board');
    }

    goToUpdate = (event) => {
        event.preventDefault();
        this.props.history.push(`/create-board/${this.state.id}`);
    }

    deleteView = async function () {
        if(window.confirm("정말로 게시글을 삭제하시겠습니까?")) {
            BoardService.deleteBoard(this.state.id).then(res => {
                console.log("delete result => "+ JSON.stringify(res));
                if (res.status === 200) {
                    this.props.history.push('/board');
                } else {
                    alert("오류가 발생했습니다.")
                }
            });
        }
    }

    render() {
        return (
            <div>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center"> Read Detail</h3>
                    <div className="card-body">
                        {this.returnBoardType(this.state.board.type)}
                        <div className="row">
                            <label> Title </label> : {this.state.board.title}
                        </div>

                        <div className="row">
                            <div className="form-group">
                                <label htmlFor="exampleFormControlTextarea1">Contents</label>
                                <textarea className="form-control" id="exampleFormControlTextarea1" rows="3"
                                          value={this.state.board.contents}/>
                            </div>
                        </div>

                        <div className="row">
                            <label> 작성일 </label> : {this.state.board.createdTime}
                        </div>
                        <div className="row">
                            <label> 수정일 </label> : {this.state.board.updatedTime}
                        </div>

                        <button className="btn btn-primary" onClick={this.goToList.bind(this)}
                                style={{marginLeft: "10px"}}>글 목록으로 이동
                        </button>
                        <button className="btn btn-info" onClick={this.goToUpdate}
                                style={{marginLeft: "10px"}}>글 수정
                        </button>
                        <button className="btn btn-danger" onClick={() => this.deleteView()}
                                style={{marginLeft: "10px"}}>글 삭제
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

export default ReadBoardComponent;